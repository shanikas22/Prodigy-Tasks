import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;

public class EcommerceScraper {
    public static void main(String[] args) {
        String url = "https://www.flipkart.com/search?q=laptop";
        String outputCsv = "products.csv";

        try {
            // Fake browser headers to avoid blocking
            Connection.Response response = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36")
                    .header("Accept-Language", "en-US,en;q=0.9")
                    .header("Accept-Encoding", "gzip, deflate, br")
                    .timeout(10000) // 10 seconds timeout
                    .method(Connection.Method.GET)
                    .execute();

            Document doc = response.parse();

            // Modify selectors based on actual Flipkart HTML structure
            Elements products = doc.select("div._1AtVbE");

            FileWriter csvWriter = new FileWriter(outputCsv);
            csvWriter.append("Product Name, Price, Rating\n");

            for (Element product : products) {
                String name = product.select("div._4rR01T").text();
                String price = product.select("div._30jeq3").text();
                String rating = product.select("div._3LWZlK").text();

                if (!name.isEmpty() && !price.isEmpty()) {
                    csvWriter.append(name).append(", ").append(price).append(", ").append(rating).append("\n");
                    System.out.println("📦 " + name + " | 💰 " + price + " | ⭐ " + rating);
                }
            }
            
            csvWriter.flush();
            csvWriter.close();
            System.out.println("✅ Data saved to " + outputCsv);

        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
