import modal.RestResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class GetRequest {

    public static void main(String[] args) {

        HttpGet get = new HttpGet("http://localhost:8080/laptop-bag/webapi/api/all");

        try (CloseableHttpClient client = HttpClientBuilder.create().build();
             CloseableHttpResponse response = client.execute(get)) {
//            StatusLine status = response.getStatusLine();
//            System.out.println("This is the status code: " + status.getStatusCode());
//            System.out.println("This is version: " + status.getProtocolVersion());

            ResponseHandler<String> responseBody = new BasicResponseHandler();

            RestResponse restResponse = new RestResponse(response.getStatusLine().getStatusCode(), responseBody.handleResponse(response));
            System.out.println(restResponse.toString());

//            String getResponseBody = responseBody.handleResponse(response);
//            System.out.println("This is our response body: "+getResponseBody);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
