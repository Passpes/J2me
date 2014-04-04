package BestDeal;

import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Wael Mallek
 */
public class ClientHandler extends DefaultHandler{
    private Vector Clients;
    String passTag = "close";
    String prenTag = "close";

    public ClientHandler() {
        Clients = new Vector();
    }

    public Client[] getClient() {
        Client[] cls = new Client[Clients.size()];
        Clients.copyInto(cls);
        return cls;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private Client currentClient;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("Client")) {

            if (currentClient != null) {
                throw new IllegalStateException("already processing a personnes");
            }
            currentClient = new Client();
        } else if (qName.equals("password")) {
            passTag = "open";
        }  else if (qName.equals("prenom_client")) {
            prenTag = "open";
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("Client")) {
            // we are no longer processing a <reg.../> tag
            Clients.addElement(currentClient);
            currentClient = null;
        } else if (qName.equals("password")) {
            passTag = "close";
        }  else if (qName.equals("prenom_client")) {
            prenTag = "close";
        }
    }
    
    // "characters" are the text inbetween tags

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentClient != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (passTag.equals("open")) {
                String pass = new String(ch, start, length).trim();
                currentClient.setPassClient(pass);
            }
              else
                    if (prenTag.equals("open")) {
                String desc = new String(ch, start, length).trim();
                currentClient.setPrenomClient(desc);
            }
        }
    }
    
}
