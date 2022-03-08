package to.tuc.tp;

import to.tuc.tp.UserInterface.Controller;
import to.tuc.tp.UserInterface.View;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        View v = new View();
        Controller c = new Controller( v);
    }
}
