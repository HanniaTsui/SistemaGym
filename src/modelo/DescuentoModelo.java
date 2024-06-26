package modelo;

import com.code.advancedsql.query.Delete;
import com.code.advancedsql.query.Insert;
import com.code.advancedsql.query.Select;
import com.code.advancedsql.query.Update;

import objetos.DescuentoObj;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DescuentoModelo {
    public static DescuentoModelo instance = new DescuentoModelo();
    
    static List<DescuentoObj> descuentoObjcList = new ArrayList<>();

    public static List<DescuentoObj> getDescuentoObjcList() {
        return descuentoObjcList;
    }

    public static DescuentoModelo obtenerInstancia() {
        return instance;
    }

    public static void subirDescuento(DescuentoObj descuento) {
        Insert nombreTabla = BaseDatos.optenerIstancia().getMySQL().table("descuento").insert();

        nombreTabla.field("ID", descuento.getID());
        nombreTabla.field("porcentaje3Meses", descuento.getPorcentaje3meses());
        nombreTabla.field("porcentaje6Meses", descuento.getPorcentaje6meses());
        nombreTabla.field("porcentaje1Anio", descuento.getPorcentaje1anio());

        try {
            nombreTabla.execute();
            System.out.println("Se subio");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void eliminarDescuento(DescuentoObj descuento) {
        Delete nombreTabla = BaseDatos.optenerIstancia().getMySQL().table("descuento").delete();

        nombreTabla.where("ID =?", descuento.getID());

        try {
            nombreTabla.execute();
            System.out.println("Se Elimino");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void actualizarDescuento(DescuentoObj descuento) {
        Update nombreTabla = BaseDatos.optenerIstancia().getMySQL().table("descuento").update();

        nombreTabla.field("porcentaje3Meses", descuento.getPorcentaje3meses());
        nombreTabla.field("porcentaje6Meses", descuento.getPorcentaje6meses());
        nombreTabla.field("porcentaje1Anio", descuento.getPorcentaje1anio());

        nombreTabla.where("ID =?", descuento.getID());

        try {
            nombreTabla.execute();
            System.out.println("Se actualizo");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void cargarDescuentos() {
        descuentoObjcList.clear();
        Select nombreTabla = BaseDatos.optenerIstancia().getMySQL().table("descuento").select();
        List<Map<String, Object>> resultTableUser;
        try {
            resultTableUser = nombreTabla.fetchAllAsList();

            for (Map<String, Object> map : resultTableUser) {
                int ID = (int) map.get("ID");
                Integer porcentaje3 = (Integer) map.get("porcentaje3Meses");
                Integer porcentaje6 = (Integer) map.get("porcentaje6Meses");
                Integer porcentaje1anio = (Integer) map.get("porcentaje1Anio");
                descuentoObjcList.add(new DescuentoObj(ID, porcentaje3, porcentaje6, porcentaje1anio));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
