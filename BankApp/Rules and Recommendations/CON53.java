/*
 * XPath Injection is an attack technique used to exploit applications that construct XPath (XML Path Language) queries from
 *  user-supplied input without validation or sanitization. Attackers can manipulate these queries to gain unauthorized access to data.
 */
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.namespace.QName;
import javax.xml.xpath.XPathVariableResolver;
import org.w3c.dom.Document;

public class CON53 {
    
    public boolean authenticate(String user, String pass, Document doc) throws XPathExpressionException {
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();

        // Set up variable resolver to safely inject parameters into the XPath expression
        xpath.setXPathVariableResolver(new XPathVariableResolver() {
            @Override
            public Object resolveVariable(QName variableName) {
                if ("username".equals(variableName.getLocalPart())) {
                    return user;
                } else if ("password".equals(variableName.getLocalPart())) {
                    return pass;
                }
                return null;
            }
        });

        // Prepare and compile the XPath expression with variables
        XPathExpression expr = xpath.compile("//users/user[@name=$username and @password=$password]");
        
        // Evaluate the compiled XPath expression on the provided document
        Boolean result = (Boolean) expr.evaluate(doc, XPathConstants.BOOLEAN);
        
        return result;
    }
}
