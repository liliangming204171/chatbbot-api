package com.gxa.chatbot.api.test;




import io.github.bonigarcia.wdm.online.HttpClient;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885848451421/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie","zsxq_access_token=83302F4D-DD3E-B76E-3FBD-D400E3BA8226_27EDC9205D2DDDE9; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22812584428481542%22%2C%22first_id%22%3A%221876122bcec550-0feab826c4cb1d8-d545429-1327104-1876122bced749%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg3NjEyMmJjZWM1NTAtMGZlYWI4MjZjNGNiMWQ4LWQ1NDU0MjktMTMyNzEwNC0xODc2MTIyYmNlZDc0OSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjgxMjU4NDQyODQ4MTU0MiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22812584428481542%22%7D%2C%22%24device_id%22%3A%221876122bcec550-0feab826c4cb1d8-d545429-1327104-1876122bced749%22%7D; zsxqsessionid=e87ccc1c14dad0f175f5d87e2a5cd02a");
        get.addHeader("Content-Type","application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String res = EntityUtils.toString(response.getEntity());
                System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

        @Test
    public void answer() throws IOException {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();

            HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/584514452515284/answer");

            post.addHeader("cookie","zsxq_access_token=83302F4D-DD3E-B76E-3FBD-D400E3BA8226_27EDC9205D2DDDE9; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22812584428481542%22%2C%22first_id%22%3A%221876122bcec550-0feab826c4cb1d8-d545429-1327104-1876122bced749%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg3NjEyMmJjZWM1NTAtMGZlYWI4MjZjNGNiMWQ4LWQ1NDU0MjktMTMyNzEwNC0xODc2MTIyYmNlZDc0OSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjgxMjU4NDQyODQ4MTU0MiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22812584428481542%22%7D%2C%22%24device_id%22%3A%221876122bcec550-0feab826c4cb1d8-d545429-1327104-1876122bced749%22%7D; zsxqsessionid=e87ccc1c14dad0f175f5d87e2a5cd02a");
            post.addHeader("Content-Type","application/json;charset=utf8");

            String paramJson = "{\n" +
                    "\t\"req_data\": {\n" +
                    "\t\t\"image_ids\": [],\n" +
                    "\t\t\"silenced\": true,\n" +
                    "\t\t\"text\": \"稍等我回答\\n\"\n" +
                    "\t}\n" +
                    "}";

            StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json","UTF-8"));
            post.setEntity(stringEntity);
            CloseableHttpResponse response = httpClient.execute(post);
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String res = EntityUtils.toString(response.getEntity());
                System.out.println(res);
            }else {
                System.out.println(response.getStatusLine().getStatusCode());
            }
        }

}
