/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BestDeal;

import javax.microedition.midlet.*;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author Passpes
 */
public class AuthentificationClient extends MIDlet implements CommandListener, Runnable {

    Display disp = Display.getDisplay(this);
    Command cmdParse = new Command("Connect", Command.SCREEN, 0);
    Command cmdBack = new Command("Back", Command.BACK, 0);
    Client[] cls;
    TextField txtPren = new TextField("Prenom", null, 50, TextField.ANY);
    TextField txtPass = new TextField("Password", null, 50, TextField.PASSWORD);
    // List lst = new List("Personnes", List.IMPLICIT);
    Form f = new Form("Login");
    Form f2 = new Form("Welcome to BestDeal");
    Form loadingDialog = new Form("Please Wait");
    StringBuffer sb = new StringBuffer();
    Image im ;

    public void startApp() {
        try {
            im=Image.createImage("/bck.jpg");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        f.append(im);
        f.append(new Spacer(20, 20));
        txtPren.setLayout(Item.LAYOUT_CENTER);
        txtPass.setLayout(Item.LAYOUT_CENTER);
        txtPren.setPreferredSize(10, 40);
        txtPass.setPreferredSize(10, 40);
        f.append(txtPren);

        f.append(txtPass);
        f.addCommand(cmdParse);
        f.setCommandListener(this);

        f.addCommand(cmdBack);
        f.setCommandListener(this);
        disp.setCurrent(f);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdParse) {
            disp.setCurrent(loadingDialog);
            Thread th = new Thread(this);
            th.start();
            if ((txtPass == null)||(txtPren == null))
            {Alert a = new Alert("Pas de données", "Veuiller remplir les formulaires", null, AlertType.INFO);
            }
        }

        if (c == List.SELECT_COMMAND) {
//            form.append("Informations Personne: \n");
//            form.append(showPersonne(lst.getSelectedIndex()));
//            disp.setCurrent(form);
        }

//        if (c == cmdBack) {
//            form.deleteAll();
//            disp.setCurrent(lst);
//        }

    }

    public void run() {
        try {
            int ch;
            String login=txtPren.getString();
            String pwd=txtPass.getString();
            StringBuffer str=new StringBuffer("");
            // this will handle our XML
            ClientHandler clientsHandler = new ClientHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/BestDeal/login.php?login="+login+"&pwd="+pwd);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
           // parser.parse(dis, clientsHandler);
            // display the result
            while ((ch = dis.read()) != -1) {
                        str.append((char) ch);
                    }
            if(str.toString().equals("OK")){
            disp.setCurrent(new Alert("Login cv bien "));
            }
            else{
                  disp.setCurrent(new Alert("omork met3ba  "));
            }
            cls = clientsHandler.getClient();
            System.out.println(str);
//            if (cls.length > 0) {
//                for (int i = 0; i < cls.length; i++) {
//                    //   lst.append(cls[i].getNom(), null);
//                }
//            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        

    }
}
