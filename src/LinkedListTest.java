import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void testToString() {
        LinkedList list = new LinkedList("123456789");
        assertEquals("123456789", list.toString());
    }

    @Test
    void testToString2() {
        LinkedList list = new LinkedList("");
        assertEquals("", list.toString());
    }

    @Test
    void appendToList1() {
        LinkedList.Node node = new LinkedList.Node(1);
        LinkedList list = new LinkedList();
        list.appendToList(node);
        assertNotNull(list);
    }

    @Test
    void appendToList2() {
        LinkedList.Node node = new LinkedList.Node(1);
        LinkedList.Node node1 = new LinkedList.Node(84);
        LinkedList list = new LinkedList();
        list.appendToList(node);
        list.appendToList(node1);
        assertEquals(node1, node.next);
    }

    @Test
    void addition1() {
        LinkedList num1 = new LinkedList("1");
        LinkedList num2 = new LinkedList("3");
        LinkedList result = new LinkedList("4");
        assertEquals(result.toString(), LinkedList.addition(num1, num2).toString());
    }

    @Test
    void addition2() {
        LinkedList num1 = new LinkedList("19023819381");
        LinkedList num2 = new LinkedList("95284703733");
        LinkedList result = new LinkedList("114308523114");
        assertEquals(result.toString(), LinkedList.addition(num1, num2).toString());
    }

    @Test
    void addition3() {
        LinkedList num1 = new LinkedList("");
        LinkedList num2 = new LinkedList("95284703733");
        LinkedList result = new LinkedList("95284703733");
        assertEquals(result.toString(), LinkedList.addition(num1, num2).toString());
    }

    @Test
    void addition4() {
        LinkedList num1 = new LinkedList("");
        LinkedList num2 = new LinkedList("95284703733");
        LinkedList result = new LinkedList("95284703733");
        assertEquals(result.toString(), LinkedList.addition(num1, num2).toString());
    }

    @Test
    void addition5() {
        LinkedList num1 = new LinkedList("55");
        LinkedList num2 = new LinkedList("9865");
        LinkedList result = new LinkedList("9920");
        assertEquals(result.toString(), LinkedList.addition(num1, num2).toString());
    }

    @Test
    void addition6() {
        LinkedList num1 = new LinkedList("5334");
        LinkedList num2 = new LinkedList("1");
        LinkedList result = new LinkedList("5335");
        assertEquals(result.toString(), LinkedList.addition(num1, num2).toString());
    }

    @Test
    void mult1() {
        LinkedList num1 = new LinkedList("99");
        LinkedList num2 = new LinkedList("345");
        LinkedList result = new LinkedList("34155");
        assertEquals(result.toString(), Objects.requireNonNull(LinkedList.mult(num1, num2)).toString());
    }

    @Test
    void mult3() {
        LinkedList num1 = new LinkedList("");
        LinkedList num2 = new LinkedList("345");
        LinkedList result = new LinkedList("345");
        assertEquals(result.toString(), Objects.requireNonNull(LinkedList.mult(num1, num2)).toString());
    }


    @Test
    void mult2() {
        LinkedList num1 = new LinkedList("2321491");
        LinkedList num2 = new LinkedList("34124354");
        LinkedList result = new LinkedList("79219380691814");
        assertEquals(result.toString(), Objects.requireNonNull(LinkedList.mult(num1, num2)).toString());
    }

    @Test
    void mult4() {
        LinkedList num1 = new LinkedList("");
        LinkedList num2 = new LinkedList("");
        assertEquals(null, LinkedList.mult(num1, num2));
    }

    @Test
    void mult5() {
        LinkedList num1 = new LinkedList("323312");
        LinkedList result = new LinkedList("323312");
        LinkedList num2 = new LinkedList("");

        assertEquals(result.toString(), LinkedList.mult(num1, num2).toString());
    }


    @Test
    void expo1() {
        LinkedList num1 = new LinkedList("50");
        LinkedList num2 = new LinkedList("5");
        LinkedList result = new LinkedList("312500000");
        assertEquals(result.toString(), (LinkedList.expo(num1, num2)).toString());
    }

    @Test
    void expo2() {
        LinkedList num1 = new LinkedList("2");
        LinkedList num2 = new LinkedList("4000");
        LinkedList result = new LinkedList("13182040934309431001038897942365913631840191610932727690928034502417569281128344551079752123172122033140940756480716823038446817694240581281731062452512184038544674444386888956328970642771993930036586552924249514488832183389415832375620009284922608946111038578754077913265440918583125586050431647284603636490823850007826811672468900210689104488089485347192152708820119765006125944858397761874669301278745233504796586994514054435217053803732703240283400815926169348364799472716094576894007243168662568886603065832486830606125017643356469732407252874567217733694824236675323341755681839221954693820456072020253884371226826844858636194212875139566587445390068014747975813971748114770439248826688667129237954128555841874460665729630492658600179338272579110020881228767361200603478973120168893997574353727653998969223092798255701666067972698906236921628764772837915526086464389161570534616956703744840502975279094087587298968423516531626090898389351449020056851221079048966718878943309232071978575639877208621237040940126912767610658141079378758043403611425454744180577150855204937163460902512732551260539639221457005977247266676344018155647509515396711351487546062479444592779055555421362722504575706910949376");
        assertEquals(result.toString(), (LinkedList.expo(num1, num2)).toString());
    }

    @Test
    void expo3() {
        LinkedList num1 = new LinkedList("400");
        LinkedList num2 = new LinkedList("");
        LinkedList result = new LinkedList("400");
        assertEquals(result.toString(), (LinkedList.expo(num1, num2)).toString());
    }

    @Test
    void expo4() {
        LinkedList num1 = new LinkedList("");
        LinkedList num2 = new LinkedList("");
        LinkedList result = new LinkedList("");
        assertEquals(result.toString(), (LinkedList.expo(num1, num2)).toString());
    }

    @Test
    void expo5() {
        LinkedList num1 = new LinkedList("50");
        LinkedList num2 = new LinkedList("0");
        LinkedList result = new LinkedList("1");
        assertEquals(result.toString(), (LinkedList.expo(num1, num2)).toString());
    }



}
