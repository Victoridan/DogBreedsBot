package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class DogParser{
  private static final String base_url = "https://www.purina.ru";

public DogBreed parseDog(String url){
  try{
    Document doc = Jsoup.connect(url).get();
    DogBreed breed = new DogBreed();
    Element namebreedName = doc.selectFirst("#block-ttt-mainpagecontent > div > div.breed-details > div.component-wrapper > div > div > div > div > div.hero-small--content-area-wrapper > div.hero-small--content-area.hero-small--breed.hero-small--breed__dog > div > h1");
    if (name != 0){
      String name = breedName.text()
        breed.setName(name);
        return breed;
      
    }else{
      System.out.println("Не удалось найти название породы((");
    }
    
  }catch(IOException e){
    e.printStackTrace();
    return null;
  }
}
//4 шаг: далее пойдет создание метода парсдог. аргумент будет урл в формате строка пжпжп
 //5 : также трай кэч будем юзать еще чтобы все не сломалось к #####
//ИСПРАВИТЬ ОШИБКИ ОТ ДС. САМАЯ ЛЕВАЯ ВКЛАДКА
