package fr.univrouen.rss22.controllers;

import fr.univrouen.rss22.model.Item;
import fr.univrouen.rss22.model.TestRSS;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
public class RSSController{
    @GetMapping("/resume")
    public String getListRSSinXML(){
        return "Envoi de la liste des flux RSS";
    }
    @GetMapping("/id")
    public String getRSSinXML(@RequestParam(value="guid") String texte){

        return ("Détail du contenu RSS demandé : "+ texte);
    }

    @GetMapping("/test")
    public String getTest(@RequestParam(value="nb") int number,@RequestParam(value="search") String search ){

        return ("Test : \n <br/> guid= "+ number + "\n <br/> titre= "+search);
    }


    @RequestMapping(value="/testpost", method = RequestMethod.POST, consumes = "application/xml")
    public String postTest(@RequestBody String flux){
        return ("<result><response>Message reçu : </response>"+ flux + "</result>");
    }

    @PostMapping(value="/postrss", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public String postRSS(){
        TestRSS rss = new TestRSS();
        return rss.loadFileXML();
    }


    @RequestMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody Item getXML() {
        Item it = new Item("12345678","Test item","2022-05-01T11:22:33");
        return it;

    }
}

