package filereader;

import java.lang.reflect.Field;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BlockTest extends TestCase {
    
    Block newBlock;
    
    public BlockTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        newBlock = new Block("NAZWA_BLOKU", 2, 12, "#", 16, 100);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetBlockName() {
        assertEquals("NAZWA_BLOKU", newBlock.getBlockName());
    }
    
    @Test
    public void testGetBarNumber() {
        assertEquals(2, newBlock.getBarNumber());
    }    
    
    @Test
    public void testGetBarPieces() {
        assertEquals(12, newBlock.getBarPieces());
    }
    
    @Test
    public void testGetBarSymbol() {
        assertEquals("#", newBlock.getBarSymbol());
    }
    
    @Test
    public void testGetBarDiameter() {
        assertEquals(16, newBlock.getBarDiameter());
    }
    
    @Test
    public void testGetBarLength() {
        assertEquals(100, newBlock.getBarLength(), 0);
    }
    
    @Test
    public void testSetBlockName() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        // given
        final Block theBlock = new Block();
        
        // when
        theBlock.setBlockName("NEW_BLOCK");
        
        // then
        final Field field = theBlock.getClass().getDeclaredField("blockName");
        field.setAccessible(true);
        assertEquals("Fields didn't match", "NEW_BLOCK", field.get(theBlock));
    }
    
    @Test
    public void testSetBarNumber() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        // given
        final Block theBlock = new Block();
        
        // when
        theBlock.setBarNumber(34);
        
        // then
        final Field field = theBlock.getClass().getDeclaredField("barNumber");
        field.setAccessible(true);
        assertEquals("Fields didn't match", 34, field.get(theBlock));
    }
    
    @Test
    public void testSetBarPieces() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        // given
        final Block theBlock = new Block();
        
        // when
        theBlock.setBarPieces(89);
        
        // then
        final Field field = theBlock.getClass().getDeclaredField("barPieces");
        field.setAccessible(true);
        assertEquals("Fields didn't match", 89, field.get(theBlock));
    }
    
    @Test
    public void testSetBarSymbol() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        // given
        final Block theBlock = new Block();
        
        // when
        theBlock.setBarSymbol("#");
        
        // then
        final Field field = theBlock.getClass().getDeclaredField("barSymbol");
        field.setAccessible(true);
        assertEquals("Fields didn't match", "#", field.get(theBlock));
    }
    
    @Test
    public void testSetBarDiameter() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        // given
        final Block theBlock = new Block();
        
        // when
        theBlock.setBarDiameter(32);
        
        // then
        final Field field = theBlock.getClass().getDeclaredField("barDiameter");
        field.setAccessible(true);
        assertEquals("Fields didn't match", 32, field.get(theBlock));
    }
    
    @Test
    public void testSetBarLength() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        // given
        final Block theBlock = new Block();
        
        // when
        theBlock.setBarLength(250.0);
        
        // then
        final Field field = theBlock.getClass().getDeclaredField("barLength");
        field.setAccessible(true);
        assertEquals("Fields didn't match", 250.0, field.get(theBlock));
    }
}
