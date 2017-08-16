import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class GetRequest {

    public static void main(String[] args) {

        try {
            HttpGet get = new HttpGet("http://localhost:8080/laptop-bag/webapi/api/all");
            CloseableHttpClient client = HttpClientBuilder.create().build();

            CloseableHttpResponse response = client.execute(get);
            StatusLine status = response.getStatusLine();
            System.out.println("This is the status code: " + status.getStatusCode());
            System.out.println("This is version: " + status.getProtocolVersion());
            client.close();
            response.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
