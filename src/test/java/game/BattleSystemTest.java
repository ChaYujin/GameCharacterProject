package game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.character.Elf;
import game.enemy.Enemy;

public class BattleSystemTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    BattleSystem battle = new BattleSystem();
    Character hero = new Elf("Artemis");
    
    
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testFight() {
        battle.fight(hero, new Enemy("드래곤", 120));
        
        String expectedOutput = "전투 시작! Artemis VS 드래곤\r\n" +
                                "-- 턴 시작 --\r\n" +
                                "드래곤의 반격!\r\n" +
                                "Artemis의 남은 HP: 85\r\n" +
                                "-- 턴 시작 --\r\n" +
                                "드래곤의 반격!\r\n" +
                                "Artemis의 남은 HP: 70\r\n" +
                                "-- 턴 시작 --\r\n" +
                                "드래곤를 쓰러뜨렸습니다!\r\n" +
                                "전투 종료.\r\n";
        
        assertEquals(expectedOutput, outContent.toString());
    }
}
