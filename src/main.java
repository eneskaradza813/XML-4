
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.stream.XMLStreamException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


public class main {

    public static void main(String[] args) throws IOException, XMLStreamException, XPathExpressionException {

        XPathFactory factory = XPathFactory.newInstance();
        XPath path = factory.newXPath();
        XPathExpression xPathExpression = path.compile("//employee[position()<= 2]/firstname | //employee[last()]/firstname");
        
        File xmlDocument = new File("C:\\Javalearning\\XMLL\\src\\employes.xml");
        InputSource inputSource = new InputSource(new FileInputStream(xmlDocument));
        
        Object result = xPathExpression.evaluate(inputSource, XPathConstants.NODESET);
        
        NodeList nodeList = (NodeList)result;
        
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.print("Node name: " + nodeList.item(i).getNodeName());
            System.out.print(" Node value: " + nodeList.item(i).getFirstChild().getNodeValue());
            System.out.print("\n");
        }
    }

}
