package Utils

import au.com.bytecode.opencsv.CSVReader

/**
 * Created by vinodk on 08-11-2016.
 */
class csvHelper {

    static CSVReader reader
    private static String rootDir = new File(".").getCanonicalPath()
    public csvHelper(){
        reader = new CSVReader(new FileReader(System.getProperty("csvFilePath").replace("/",File.separator)));
    }
    public static void main(String[] rags){
        getCsvData()
    }

static  def getCsvData(){
        def obj;
    println rootDir
    String relPath= rootDir+"//src//test//resources//testFiles.csv".replace("//",File.separator)
    reader = new CSVReader(new FileReader(relPath));
//    reader.g
    List<String[]> test=reader.readAll()
    List<List> rows=new ArrayList<List>();

    Iterator<String[]> rowsIterator = test.iterator()

    while (rowsIterator.hasNext()){
        List tempList=Arrays.asList(rowsIterator.next())
        if (!(tempList.size() == 1 && tempList.getAt(0).equals(""))) {
            rows.add(tempList)
        }
    }

    int i=test.size()-1
        println "size-->"+test.size()
        while(i>0){
            println test[i]
            i--;
        }
    }
}
