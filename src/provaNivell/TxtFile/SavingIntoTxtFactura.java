package provaNivell.TxtFile;

import provaNivell.Class.Factura;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SavingIntoTxtFactura {

    public static void readList(List<Factura> listObjects, String arxiu) throws IOException {
        String data;

        if (listObjects != null){
            for (Factura object : listObjects) {
                data = "\n" + object.toString();
                SaveIntoNewFile(data, arxiu);
            }
        }
    }

    public static void SaveIntoNewFile(String data, String arxiu){
        String PathFile = "/Users/marinaroyoterol/GitHub/ProvaNivell/src/provaNivell1/" + arxiu;
        FileWriter fw = null;
        File OutFile;
        boolean first = false;

        try {
            OutFile = new File(PathFile);

            if (!OutFile.exists()){
                OutFile.getParentFile().mkdir();
                OutFile.createNewFile();
            }

            fw = new FileWriter(OutFile, true);

            if (!first){
                first = true;
                fw.write(data);
            } else {
                fw.write("\n" + data);
            }


        } catch (IOException ex){
            ex.printStackTrace();
        } finally {
            try {
                if (fw != null){
                    fw.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
