package io.github.talelin.latticy.common.schedule;

import com.hankcs.lucene.HanLPAnalyzer;
import io.github.talelin.latticy.mapper.my.SpuMapper;
import io.github.talelin.latticy.model.my.Spu;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/6/29 10:50
 * @Version 1.0
 * 每天凌晨1点基于商品名称构建Lucene倒排索引的定时任务
 */
@Component
@EnableScheduling
@Slf4j
public class LuceneSchedule {

    @Autowired
    private SpuMapper spuMapper;

    /**
     * @Description: 每天晚上11点，需要根据 product 表中的数据，重新构建 luence 索引
     * @Param:
     * @return:
     * @Author: Guiquan Chen
     * @Date: 2021/6/29
     * 应该需要每天晚上23：00执行一次
     */
    @Scheduled(cron = "${task.lucene-time}")
    public void luceneTask() {
        System.out.println("执行倒排索引的定时任务");

        // 创建存储luence索引的目录
        Directory directory= null;
        try {
            directory = FSDirectory.open(new File("D:/project/index-luence").toPath());
            System.out.println("创建存储luence索引的目录success");
        } catch (IOException e) {
            log.error("创建存储luence索引目录时，出现异常",e);
            return;
        }
        // 创建中文分词器
        Analyzer analyzer=new HanLPAnalyzer();
        // 创建索引配置对象
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        IndexWriter writer = null;
        try {
            // 创建索引写入器
            writer =new IndexWriter(directory, config);
            // 在商品表中检索 update_time 字段为当天的数据，然后取 title 字段
            List<Spu> spus = spuMapper.searchIdAndTitle();
            if(spus == null || spus.size() < 1) return;
            Document document=new Document();
            for(Spu spu : spus) {
                document.add(new TextField("id", spu.getId().toString(), Field.Store.YES));
                document.add(new TextField("title", spu.getTitle(), Field.Store.YES));
                try {
                    writer.addDocument(document);
                } catch (IOException e) {
                    log.error("将数据写入Lucene索引文件时，出现异常, spu=[{}]",spu.toString(),e);
                    break;
                }
                // 清空document对象中的Field数据
                document.clear();
            }
        } catch (IOException e) {
            log.error("创建索引写入器时，出现异常",e);
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                log.error("关闭写入器I/O时，出现异常",e);
                e.printStackTrace();
            }
        }
    }
}
