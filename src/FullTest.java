import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class FullTest {

	@Test
	void testAdd() {
		String[] args = {"add", "s0", "t0", "t2"};
		String linha = Functions.buildFunction(args);
		assertEquals("00000001000010101000000000100000", linha);
	}
	@Test
	void testSub() {
		String[] args = {"sub", "s0", "s1", "s2"};
		String linha = Functions.buildFunction(args);
		assertEquals("00000010001100101000000000100010", linha);
	}
	@Test
	void testDiv() {
		String[] args = {"div", "s0", "s1"};
		String linha = Functions.buildFunction(args);
		assertEquals("00000010000100010000000000011010", linha);
	}
	@Test
	void testAnd() {
		String[] args = {"and", "s0", "s1", "s2"};
		String linha = Functions.buildFunction(args);
		assertEquals("00000010001100101000000000100100", linha);
	}
	@Test
	void testOr() {
		String[] args = {"or", "s0", "s1", "s2"};
		String linha = Functions.buildFunction(args);
		assertEquals("00000010001100101000000000100101", linha);
	}
	@Test
	void testXor() {
		String[] args = {"xor", "s0", "s1", "s2"};
		String linha = Functions.buildFunction(args);
		assertEquals("00000010001100101000000000100110", linha);
	}
	@Test
	void testNor() {
		String[] args = {"nor", "s0", "s1", "s2"};
		String linha = Functions.buildFunction(args);
		assertEquals("00000010001100101000000000100111", linha);
	}
	@Test
	void testSlt() {
		String[] args = {"slt", "s0", "s1", "s2"};
		String linha = Functions.buildFunction(args);
		assertEquals("00000010001100101000000000101010", linha);
	}
	@Test
	void testSll() {
		String[] args = {"sll", "s0", "s1", "1"};
		String linha = Functions.buildFunction(args);
		assertEquals("00000000000100011000000001000000", linha);
	}
	@Test
	void testSrl() {
		String[] args = {"srl", "s0", "s1", "1"};
		String linha = Functions.buildFunction(args);
		assertEquals("00000000000100011000000001000010", linha);
	}
	void testJr() {
		String[] args = {"jr", "s0"};
		String linha = Functions.buildFunction(args);
		assertEquals("00000010000000000000000000001000", linha);
	}
	@Test
	void testAddi() {
		String[] args = {"addi", "s0", "s1", "1"};
		String linha = Functions.buildFunction(args);
		assertEquals("00100010001100000000000000000001", linha);
	}
	@Test
	void testAndi() {
		String[] args = {"andi", "s0", "s1", "1"};
		String linha = Functions.buildFunction(args);
		assertEquals("00110010001100000000000000000001", linha);
	}
	@Test
	void testOri() {
		String[] args = {"ori", "s0", "s1", "1"};
		String linha = Functions.buildFunction(args);
		assertEquals("00110110001100000000000000000001", linha);
	}
	@Test
	void testSlti() {
		String[] args = {"slti", "s0", "s1", "1"};
		String linha = Functions.buildFunction(args);
		assertEquals("00101010001100000000000000000001", linha);
	}
	void testBeq() {
		String[] args = {"beq", "s0", "s1", "4"};
		String linha = Functions.buildFunction(args);
		assertEquals("00010010001100000000000000000100", linha);
	}
	void testBne() {
		String[] args = {"bne", "s0", "s1", "4"};
		String linha = Functions.buildFunction(args);
		assertEquals("00010110001100000000000000000100", linha);
	}
	void testLw() {
		String[] args = {"lw", "s0", "4(s1)"};
		String linha = Functions.buildFunction(args);
		assertEquals("10001110001100000000000000000100", linha);
	}
	void testSw() {
		String[] args = {"sw", "s0", "4(s1)"};
		String linha = Functions.buildFunction(args);
		assertEquals("10101110001100000000000000000100", linha);
	}
	void testJ() {
		String[] args = {"j", "1024"};
		String linha = Functions.buildFunction(args);
		assertEquals("00001000000000000000010000000000", linha);
	}
	void testJal() {
		String[] args = {"j", "1024"};
		String linha = Functions.buildFunction(args);
		assertEquals("00001100000000000000010000000000", linha);
	}
}
