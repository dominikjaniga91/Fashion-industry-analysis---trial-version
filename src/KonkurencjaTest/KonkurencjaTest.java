package KonkurencjaTest;

import java.util.*;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class KonkurencjaTest {

    public static void main(String[] args) throws Exception {

        // HOUSE

        Document doc = Jsoup.connect("https://www.housebrand.com/cz/cz/muz/kolekce/bundy-kabaty").get();

        Elements productName = doc.getElementsByClass("es-product-name");
        Elements price = doc.getElementsByClass("es-product-price");
        Elements sku = doc.getElementsByAttribute("data-sku");

        List<String> html2 = productName.eachText();
        List<String> html5 = price.eachText();
        List<String> sku2 = sku.eachAttr("data-sku");



       System.out.println("Nazwa  + cena  +  mdk");
        for (int i =0; i<html5.size(); i++){

            System.out.println(html2.get(i) + " : " + html5.get(i) + " : " + sku2.get(i));
        }

        // BERSHKA

        Document bershka = Jsoup.connect("https://www.bershka.com/pl/m%C4%99%C5%BCczyzna/kolekcja/bluzy-c1010193244.html").get();


        Elements bershkaPrice = bershka.getElementsByAttribute("href");
        Elements bershkaMdk = bershka.getElementsByAttribute("alt");
        Elements bershkaName = bershka.getElementsByAttribute("src");


        List<String> bershkaPrice2 = bershkaPrice.eachText();
        List<String> bershkaName2 = bershkaName.eachAttr("alt");
        List<String> bershkaMdk2 = bershkaMdk.eachAttr("src");


      System.out.println("MDK      +     nazwa     +      cena");

        for (int i =0; i<bershkaMdk2.size(); i++){

                if (bershkaMdk2.get(i).charAt(0) == 'h') {
                    if (bershkaMdk2.get(i).charAt(8) == 's')
                        System.out.println(bershkaMdk2.get(i).substring(50, 62) + " - " + bershkaPrice2.get(i));
            }
        }


        // PULLL & BEAR

        List<Document> documentsArray = new ArrayList<Document>();

        Document pullBear = Jsoup.connect("https://www.pullandbear.com/fi/man/clothing/coats-and-jackets-c1030009520.html").get();

        for (int j = 0; j < documentsArray.size(); j++) {

            Elements pullBearNamePrice = pullBear.getElementsByAttribute("href");
            Elements pullBearMdk = pullBear.getElementsByAttribute("alt");

            List<String> pullBearNamePriceTable = pullBearNamePrice.eachText();
            List<String> pullBearMdkTable = pullBearMdk.eachAttr("src");
            List<String> pullBearCountry = pullBearNamePrice.eachAttr("href");

            System.out.println(pullBearCountry);

            System.out.println( (j+1) + "brand  +  kraj  + mdk  + nazwa  +  cena ");

            for (int i = 0; i < pullBearMdkTable.size(); i++) {

                if (!("null".equals(pullBearMdkTable.get(i)))) {
                    if (pullBearMdkTable.get(i).charAt(33) == 'p' && pullBearMdkTable.get(i).charAt(38) == 's') {

                        System.out.println( pullBearCountry.get(30).substring(12, 23) +" : " + pullBearCountry.get(30).substring(24, 26) + " : " + pullBearMdkTable.get(i).substring(53, 61) + " : " + pullBearNamePriceTable.get(i) );
                    }
                }
            }
        }
    }
}

