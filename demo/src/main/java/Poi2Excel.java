/**
 * Created by zhaojin on 17/4/19.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class Poi2Excel
{
    public static void main(String[] args) throws IOException
    {
        Poi2Excel pe = new Poi2Excel();
        //pe.createXls();
        //pe.readXls();
        //pe.decorateXls();
        //pe.applicationXls();
        //pe.writeApplicationXls();

    }

    public void createXls() throws IOException
    {
        //创建一个空白的WorkBook
        HSSFWorkbook wb = new HSSFWorkbook();
        //基于上面的WorkBook创建属于此WorkBook的Sheet，
        HSSFSheet st = wb.createSheet("测试页");
        //创建属于上面Sheet的Row，参数0可以是0～65535之间的任何一个，注意，尽管参数是Int类型，但是Excel最多支持65536行
        //注意只有我们先创建了对象，我们才能够进行后续的操作
        HSSFRow row = st.createRow(0);
        //创建属于上面Row的Cell，参数0可以是0～255之间的任何一个，同样，是因为Excel最大支持的列数为256列
        HSSFCell cell0 = row.createCell((short) 0);
        //设置此单元格的格式为文本，此句可以省略，Excel会自动识别。
        cell0.setCellType(HSSFCell.CELL_TYPE_STRING);
        //此处是3.0.1版的改进之处，上一版可以直接setCellValue("Hello, World!")，
        cell0.setCellValue(new HSSFRichTextString("Hello, World!"));
        //设置一个数字型的单元格
        HSSFCell cell1 = row.createCell((short) 1);
        cell1.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
        cell1.setCellValue(5.06);
        //创建一个文件输出流，指定到C盘根目录下,xls是Excel97-2003的标准扩展名，2007是xlsx，目前的POI能直接生产的还是xls格式，
        FileOutputStream writeFile = new FileOutputStream("e:/helloworld.xls");
        //把WorkBook写到流里
        wb.write(writeFile);
        //记得手动关闭流
        writeFile.close();
    }

    public void readXls() throws IOException
    {
        //指定要读取的文件，本例使用上面生成的helloworld.xls
        FileInputStream readFile = new FileInputStream("helloworld.xls");
        //创建一个WorkBook，从指定的文件流中创建，即上面指定了的文件流
        HSSFWorkbook wb = new HSSFWorkbook(readFile);
        //获取名称为“测试页”的sheet,注意，如果不能确定具体的名称，可以用getSheetAt(int)方法取得Sheet
        HSSFSheet st = wb.getSheet("测试页");
        //获得第一行，通过判断保证有这一行
        if (st.getFirstRowNum() <= 0 && st.getLastRowNum() >= 0)
        {
            HSSFRow row = st.getRow(0);
            //获取第一个单元格，如果没有被创建过则抛出异常
            HSSFCell cell0 = row.getCell((short) 0);
            //把cell中的内容按字符串方式读取出来，并显示在控制台上
            //注意，getRichStringCellValue()方法是3.0.1新追加的，
            //老版本中的getStringCellValue()方法被deprecated了
            System.out.println(cell0.getRichStringCellValue());
            HSSFCell cell1 = row.getCell((short) 1);
            System.out.println(cell1.getNumericCellValue());
            HSSFCell cell2 = row.getCell((short) 2);
            if (cell2 != null)
            {
                System.out.println(cell2.getRichStringCellValue());
            }
            else
            {
                System.out.println("第一行第三列不存在");
            }

        }
        //记得关闭流
        readFile.close();
    }

    /*
     通过applicationXls()和writeApplicationXls()我们可以发现当在合并单元格式，比如第一行的ABC三列,如果我们在applicationXls()在将数据写在了莫一列，那么
    writeApplicationXls()读取时只有读取该列才能读到数据，其它的两列为空。而且一旦去掉applicationXls()中的
    row.createCell((short) 1).setCellStyle(normalStyle);
    row.createCell((short) 2).setCellStyle(normalStyle);
    那么writeApplicationXls()中的
    System.out.print(st.getRow(0).getCell((short) 1).getRichStringCellValue()+",");
    System.out.println(st.getRow(0).getCell((short) 2).getRichStringCellValue());
    就会有空指针异常。
    同样，经过测试如果本地已有一个创建好格式的xls，那么里面合并的单元的数据默认在左上角
    */
    public void writeApplicationXls() throws IOException
    {
        FileInputStream readFile = new FileInputStream("application.xls");
        HSSFWorkbook wb = new HSSFWorkbook(readFile);
        HSSFSheet st = wb.getSheet("应用页");
        System.out.print(st.getRow(0).getCell((short) 0).getRichStringCellValue()+",");
        System.out.print(st.getRow(0).getCell((short) 1).getRichStringCellValue()+",");
        System.out.println(st.getRow(0).getCell((short) 2).getRichStringCellValue());
        for(int i=1;i<7;i++)
        {
            HSSFRow row=st.getRow(i);
            System.out.println(row.getCell((short) 1).getRichStringCellValue());
            for(int j=3;j<7;j++)
            {
                HSSFCell cell=row.getCell((short) j);
                cell.setCellValue(new HSSFRichTextString(i+","+j));
            }

        }

        FileOutputStream writeFile = new FileOutputStream("application.xls");
        wb.write(writeFile);
        writeFile.close();
    }
}

