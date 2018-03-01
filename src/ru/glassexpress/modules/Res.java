package ru.glassexpress.modules;

public class Res {
    public static final String GET_MARKS = "SELECT * FROM auto_mark ORDER BY mark_title";
    public static final String GET_MODELS = "SELECT * FROM auto_model WHERE id_auto_mark = " +
            "(SELECT id_auto_mark  FROM auto_mark WHERE mark_title=?) ORDER BY title_model";

    public static final String GET_GENERATION = "SELECT * FROM car WHERE id_model = " +
            "(SELECT id_auto_model FROM auto_model WHERE title_model=?) ORDER BY year_from";


    public static final String INSERT_MODEL = "INSERT INTO `glass_express_db`.`auto_model` (`title_model`, `id_auto_mark`) " +
            "VALUES (?, (SELECT id_auto_mark  FROM auto_mark WHERE mark_title=?))";

    public static final String INSERT_MARK = "INSERT INTO auto_mark  (`mark_title`) VALUES (?) ";

    public static final String INSERT_GENERATION = "INSERT INTO `glass_express_db`.`car` " +
            "(`year_from`, `year_to`, `id_model`) VALUES (?, ?, " +
            "(SELECT id_auto_model FROM auto_model WHERE title_model=?));";

    public static final String INSERT_GLASS = "INSERT INTO glass (id_car, id_glass_type, id_glass_options, glass_description, price_in, price_out, alert_remainder) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String INSERT_GLASS_PRICE = "";


    public static final String SELECT_GLASS =
            "SELECT glass.id_glass, CONCAT(glass_type_title, \" \", \" \", glass_option_title,  \": \", auto_mark.mark_title, \" \",auto_model.title_model, \" \", year_from, \"-\", year_to, \" \", glass_description) AS description" +
                    ", glass_type.id_glass_type, glass_options.id_glass_options,  glass_description, price_in, price_out, glass.id_car," +
                    "alert_remainder FROM glass " +
                    "LEFT JOIN (car) ON glass.id_car = car.id_car " +
                    "LEFT JOIN (auto_model) ON car.id_model = auto_model.id_auto_model " +
                    "LEFT JOIN (auto_mark) ON auto_model.id_auto_mark = auto_mark.id_auto_mark " +
                    "LEFT JOIN (glass_options) ON glass.id_glass_options = glass_options.id_glass_options " +
                    "LEFT JOIN (glass_type) ON glass.id_glass_type = glass_type.id_glass_type " +
                    "ORDER BY glass.id_glass";
    public static final String SELECT_GLASS_TYPE = "SELECT * FROM glass_type ORDER BY id_glass_type";
    public static final String SELECT_BODY_TYPE = "SELECT * FROM auto_body_type ORDER BY id_body_type";
    public static final String SELECT_GLASS_OPT ="SELECT * FROM glass_options ORDER BY id_glass_options";
    public static final String SELECT_GLASS_FACTORY ="SELECT * FROM glass_factory";
    public static final String DELETE_GENERATION = "DELETE FROM car WHERE id_car = ?";

    /// названия колонок таблицы

}
