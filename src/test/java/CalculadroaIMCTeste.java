import org.example.CalculadoraIMC;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraIMCTest {

    private static final double EPS = 0.01; // margem de erro aceitável para double

//casos normais

    @Test
    void testImcNormal() {
        double imc = CalculadoraIMC.calcularIMC(70, 1.75);
        assertEquals(22.86, imc, EPS);
        assertEquals("Peso normal", CalculadoraIMC.classificarIMC(imc));
    }

    @Test
    void testImcSobrepeso() {
        double imc = CalculadoraIMC.calcularIMC(85, 1.75);
        assertEquals(27.76, imc, EPS);
        assertEquals("Sobrepeso", CalculadoraIMC.classificarIMC(imc));
    }

    @Test
    void testImcAbaixoDoPeso() {
        double imc = CalculadoraIMC.calcularIMC(50, 1.75);
        assertEquals(16.33, imc, EPS);
        assertEquals("Abaixo do peso", CalculadoraIMC.classificarIMC(imc));
    }

//casos de borda

    @Test
    void testPesoZero() {
        assertThrows(IllegalArgumentException.class, () -> CalculadoraIMC.calcularIMC(0, 1.70));
    }

    @Test
    void testAlturaZero() {
        assertThrows(IllegalArgumentException.class, () -> CalculadoraIMC.calcularIMC(70, 0));
    }

    @Test
    void testPesoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> CalculadoraIMC.calcularIMC(-70, 1.70));
    }
}
