package org.example.pipeline;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;

/**
 * Hello world!
 */
public class Main {

    public static void main(String[] args) {

        CouchbaseCluster cluster = CouchbaseCluster.create();
        Bucket bucket = cluster.openBucket("books");

        JsonObject jsonObject = JsonObject.create();
        jsonObject.put("isbn", "978-1-4919-1889-0");
        jsonObject.put("name", "Minecraft Modding with Forge");
        jsonObject.put("free", "29.99");
        JsonDocument document = JsonDocument.create("minecraft", jsonObject);
        bucket.upsert(document);

        JsonDocument doc = bucket.get("minecraft");
        System.out.println(doc.content());
        
        System.out.println("Hello World!");
    }
}