package ru.glassexpress.modules;

public class Res {
    public static final String GET_MARKS = "SELECT * FROM auto_mark ORDER BY mark_title";
    public static final String GET_MODELS="SELECT * FROM auto_model WHERE id_auto_mark = " +
            "(SELECT id_auto_mark  FROM auto_mark WHERE mark_title=?) ORDER BY title_model";

    public static final String GET_GENERATION="SELECT * FROM car WHERE id_model = " +
            "(SELECT id_auto_model FROM auto_model WHERE title_model=?);";


    public static final String INSERT_MODEL="INSERT INTO `glass_express_db`.`auto_model` (`title_model`, `id_auto_mark`) " +
            "VALUES (?, (SELECT id_auto_mark  FROM auto_mark WHERE mark_title=?))";

    public static final String INSERT_MARK="INSERT INTO auto_mark  (`mark_title`) VALUES (?) ";

    public static final String INSERT_GENERATION="INSERT INTO `glass_express_db`.`car` " +
            "(`year_from`, `year_to`, `id_model`) VALUES (?, ?, " +
            "(SELECT id_auto_model FROM auto_model WHERE title_model=?));";

    public static final String INSERT_GLASS="";
    public static final String INSERT_GLASS_PRICE="";


    /// названия колонок таблицы

}
