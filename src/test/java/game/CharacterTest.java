package game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CharacterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    Character hero;
    
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        hero = new Character("Artemis", "Elf", 100, 50, 30);
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test
    void testAddItem(){
        for( int i=0; i<Inventory.INVENTORY_SIZE; i++ ){
            assertTrue(hero.obtainItem(new Item("검", 10, 0, 0)));
        }
    }

    @Test
    void testAddItemInventoryFull(){
        for( int i=0; i<Inventory.INVENTORY_SIZE; i++ ){
            assertTrue(hero.obtainItem(new Item("검", 10, 0, 0)));
        }
        assertFalse(hero.obtainItem(new Item("검", 10, 0, 0)));
    }


    @Test
    void testPrintInventory() {
		hero.obtainItem(new Item("검", 10, 0, 0));
		hero.obtainItem(new Item("방패", 0, 10, 0));
		hero.obtainItem(new Item("포션", 0, 0, 50));

        //when
        hero.printInventory();
    
        //then
        String expectedOutput = "Artemis의 인벤토리:\r\n" +
                                "- 검 (공격력:10, 방어력:0, 회복력:0)\r\n" +
                                "- 방패 (공격력:0, 방어력:10, 회복력:0)\r\n" +
                                "- 포션 (공격력:0, 방어력:0, 회복력:50)\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
	public void testUseItem() {
		hero.obtainItem(new Item("검", 10, 0, 0));
		hero.obtainItem(new Item("방패", 0, 10, 0));
		hero.obtainItem(new Item("포션", 0, 0, 50));

        assertTrue(hero.useItem("검"));
        assertFalse(hero.useItem("검"));
        assertEquals(hero.inventory.getItemCount(), 2);

        assertTrue(hero.useItem("방패"));
        assertEquals(hero.inventory.getItemCount(), 1);

        
        String expectedOutput = "검 아이템을 사용했습니다. 현재 능력치: HP=100, 공격력=60, 방어력=30\r\n"+
                                "방패 아이템을 사용했습니다. 현재 능력치: HP=100, 공격력=60, 방어력=40\r\n";
        assertEquals(expectedOutput, outContent.toString());
	}

    @Test
	public void testAttack() {
        hero.attack("고블린", 50);
        
        String expectedOutput = "Artemis이(가) 고블린을(를) 50의 데미지로 공격했습니다.\r\n" +
                                "고블린 처치 완료!\r\n";
                                
        assertEquals(expectedOutput, outContent.toString());
	}

    @Test
	public void testGetItemCount() {
		hero.obtainItem(new Item("검", 10, 0, 0));
		hero.obtainItem(new Item("방패", 0, 10, 0));
		hero.obtainItem(new Item("포션", 0, 0, 50));
		hero.obtainItem(new Item("포션", 0, 0, 50));

        int count = hero.inventory.getItemCount();
        assertEquals(4, count);
	}
}
