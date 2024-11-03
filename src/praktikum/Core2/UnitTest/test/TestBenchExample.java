package praktikum.Core2.UnitTest.test;

import org.junit.jupiter.api.*;

public class TestBenchExample {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Запускается перед всеми тестами");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Запускается после всех тестов");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("--Запускается перед каждым");
    }

    @AfterEach
    void afterEach() {
        System.out.println("--Запускается после каждого");
    }


    @Test
    public void someTestOne() {
        System.out.println("-- --Running test 1");
    }

    @Test
    public void someTestTwo() {
        System.out.println("-- --Running test 2");
    }

    /*
    Вывод должен быть таким:
    Запускается перед всеми тестами
    --Запускается перед каждым
    -- --Running test 1
    --Запускается после каждого
    --Запускается перед каждым
    -- --Running test 2
    --Запускается после каждого
    Запускается после всех тестов
     */
}

