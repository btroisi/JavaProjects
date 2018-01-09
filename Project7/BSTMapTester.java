import java.util.ArrayList;
import java.util.Comparator;

// The class is designed to test the BSTMap.
// It uses two key/value types and does some fairly light-weight testing.
// I.e. if your code passes this test, that does not serve as a guarantee
// that it works perfectly in all situations.
class BSTMapTester {

    public static void main( String[] args ) {
        // Test with String key and Integer value, with keys in descending order
        BSTMap<String,Integer> map = new BSTMap<String,Integer>(new DescendingStringComparator());
        map.put( "B", 2 );
        map.put( "A", 1);
        map.put( "D", 2 );
        map.put( "C", 2 );
        System.out.println( "Should print D C B A" );
        map.printInOrder();
        System.out.println();
        System.out.println( "Has A: should be true and is " + map.containsKey( "A" ) );
        System.out.println( "Has G: should be false and is " + map.containsKey( "G" ) );
        map.put( "D", 3 );
        System.out.println( "D should now have value 3 and now has value " + map.get( "D" ) );
        System.out.println( "The tree should have 4 elements and has " + map.size() + " elements" );
        ArrayList<KeyValuePair<String,Integer>> pairs  = map.getPairs();
        System.out.println( "The pairs should be: [B 2, D 3, C 2, A 1]" );
        System.out.println( "The pairs are: " + pairs );
        
        // Test with Integer key and Float value, with keys in ascending order
        System.out.println( "\nNow testing map with Integer keys and Float values" );
        BSTMap<Integer,Float> map2 = new BSTMap<Integer,Float>(new AscendingIntegerComparator());
        map2.put( new Integer(1), new Float(4.5) );
        map2.put( new Integer(3), new Float(9.0) );
        System.out.println( "The pairs should be: [1 4.5, 3 9.0]" );
        System.out.println( "The pairs are: " + map2.getPairs() );
        boolean gotIt = map2.containsKey( new Integer(1) );
        System.out.println( "contains(1) should return true. It returns " + gotIt );
        if (!gotIt) {
            System.out.println( "Be sure to use the comparator when you check for equality in your tree. Dont compare pointers." );
        }
    }        
}

// For testing purposes! Make a comparator that will order a pair of strings in reverse
// alphabetical order
class DescendingStringComparator implements Comparator<String> {
    public int compare( String i1, String i2 ) {
        // returns positive number if i2 comes after i1 lexicographically
        return i2.compareTo(i1);
    }
}

// For testing purposes! Make a comparator that will order a pair of integers in
// numeric order
class AscendingIntegerComparator implements Comparator<Integer> {
    public int compare( Integer i1, Integer i2 ) {
        // returns negative number if i1 is greater than i2
        return i2-i1;
    }
}
