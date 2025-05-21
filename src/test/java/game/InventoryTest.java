package game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    Character hero;
    
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        hero = new Character("Artemis", "Elf", 100, 50, 30);
		hero.obtainItem(new Item("검", 10, 0, 0));
		hero.obtainItem(new Item("방패", 0, 10, 0));
		hero.obtainItem(new Item("포션", 0, 0, 50));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test
    void testPrintInventory() {
        //when
        hero.inventory.printInventory();
    
        //then
        String expectedOutput = "- 검 (공격력:10, 방어력:0, 회복력:0)\r\n" +
                                "- 방패 (공격력:0, 방어력:10, 회복력:0)\r\n" +
                                "- 포션 (공격력:0, 방어력:0, 회복력:50)\r\n";
                                
        assertEquals(expectedOutput, outContent.toString());
    }
    
    @Test
    void testPrintItemDetails() {
		hero.inventory.printItemDetails();
        
        String expectedOutput = "아이템: 검, 공격력: 10, 방어력: 0, 회복량: 0\r\n" +
                                "아이템: 방패, 공격력: 0, 방어력: 10, 회복량: 0\r\n" +
                                "아이템: 포션, 공격력: 0, 방어력: 0, 회복량: 50\r\n";

        assertEquals(expectedOutput, outContent.toString());
    }
}
