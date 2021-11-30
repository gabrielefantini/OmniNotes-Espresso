import org.sikuli.script.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.python.modules.time.Time.sleep;
import static org.sikuli.basics.FileManager.exists;

public class TestSikuli {

    @Test
    public void insertNewNote(){
        Screen s = new Screen();
        String path = "C:\\"+"\\Users\\gabri\\InsertNewNote.sikuli\\";
        try{
            s.click(path + "1636537755998.png");
            s.click(path +"1636537782883.png");
            s.click(path +"1636537803951.png");
            s.type("New Note");
            s.click(path +"1636537831061.png");
            Assert.assertTrue(exists(path+"1636537843807.png"));
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }

    @Test
    public void archiveNote(){
        Screen s = new Screen();
        String path = "C:\\"+"\\Users\\gabri\\ArchiveNote.sikuli\\";
        try{
            Match t = s.find(path + "1636540108598.png");
            s.dragDrop(t, t.offset(new Location(-200,0)));
            s.click(path + "1636543425997.png");
            s.click(path + "1636543443315.png");
            Assert.assertTrue(exists(path+"1636540108598.png"));
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }

    @Test
    public void searchNote(){
        Screen s = new Screen();
        String path = "C:\\"+"\\Users\\gabri\\SearchNote.sikuli\\";
        try{
            s.click(path + "1636543638240.png");
            s.click(path +"1636543663192.png");
            s.click(path +"1636543679696.png");
            s.type("X");
            s.click(path +"1636543693128.png");

            s.click(path + "1636543638240.png");
            s.click(path +"1636543663192.png");
            s.click(path +"1636543679696.png");
            s.type("Y");
            s.click(path +"1636543693128.png");

            s.click(path + "1636543638240.png");
            s.click(path +"1636543663192.png");
            s.click(path +"1636543679696.png");
            s.type("Z");
            s.click(path +"1636543693128.png");

            s.click(path + "1636543846996.png");
            s.type("X");
            s.type(Key.ENTER);
            Assert.assertTrue(exists(path+"1636543875022.png"));
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }

    @Test
    public void info(){
        Screen s = new Screen();
        String path = "C:\\"+"\\Users\\gabri\\GoToInfo.sikuli\\";
        try{
            s.click(path + "1636545060608.png");
            s.click(path + "1636545070415.png");
            s.wheel(Mouse.WHEEL_DOWN, 80);
            s.click(path + "1636545097456.png");
            Assert.assertTrue(exists(path+"1636545117997.png"));
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteNoteAndEmptyTrash(){
        Screen s = new Screen();
        String path = "C:\\"+"\\Users\\gabri\\DeleteNoteAndEmptyTrash.sikuli\\";
        try{
            s.click(path + "1636552727265.png");
            s.click(path + "1636552736417.png");
            s.click(path + "1636552749823.png");
            s.type("New Note");

            s.click(path + "1636552759942.png");
            s.click(path + "1636552773948.png");
            s.click(path + "1636552781504.png");
            s.click(path + "1636552790152.png");

            s.click(path + "1636552821611.png");
            s.click(path + "1636552828850.png");

            Assert.assertTrue(exists(path+"1636552841335.png"));

            s.click(path + "1636552848227.png");
            s.click(path + "1636552856153.png");
            s.click(path + "1636552861835.png");

            sleep(2);

            Assert.assertFalse(exists(path+"1636552841335.png"));
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }
}