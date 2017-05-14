package cz.zcu.kiv.si.sportbot.dataLoader.enums;

/**
 * @author Marek Rasocha
 *         date 14.05.2017.
 */
public enum SportType {
    AEROBIC("aerobic"),
    BADMINTON("badminton"),
    BASKETBALL("basketball"),
    BEACH_VOLEJBAL("beach volejbal"),
    BODYFORMING("bodyforming"),
    BODYSTYLING("bodystyling"),
    BOSU("bosu"),
    BOWLING("bowling"),
    BOX("BOX"),
    CORE("core"),
    CROSSFIT("crossfit"),
    CYKLISTIKA("cyklistika"),
    DANCE("dance"),
    DEEP_WORK("deep work"),
    DETSKE_HRISTE("detske hriste"),
    FITBOX("fitbox"),
    FITNESS("fitness"),
    FLEXIBAR("flexibar"),
    FLOWIN("flowin"),
    FUTSAL("futsal"),
    GOLF("golf"),
    GTS("gts"),
    GYM("gym"),
    HALA("hala"),
    HAZENA("hazena"),
    HEAT("heat"),
    HIIT("hiit"),
    HOKEJBAL("hokejbal"),
    HOROLEZECKA_STENA("horolezecka stena"),
    CHI_TONING("chi-toning"),
    INLINE("in-line"),
    JOGA("joga"),
    JOGGING("jogging"),
    K2("k2"),
    KARDIO("kardio"),
    KICKBOX("kickbox"),
    KRUHOVY_TRENINK("kruhovy trenink"),
    LANOVE_CENTRUM("lanove centrum"),
    MINIGOLF("minigolf"),
    NOHEJBAL("nohejbal"),
    PILATES("pilates"),
    PILOXING("piloxing"),
    PLOCHE_BRICHO("ploche bricho"),
    PORT_DE_BRAS("port de bras"),
    POSILOVNA("posilovna"),
    POWER_PLATE("power plate"),
    POWERJOGA("powerjoga"),
    PUMPING("pumping"),
    SEBEOBRANA("sebeobrana"),
    SKATE_PARK("skate park"),
    SQUASH("squash"),
    STEP("step"),
    STREETBALL("streetball"),
    TABATA("tabata"),
    TEHOTENSKE_CVICENI("tehotenske cviceni"),
    TENIS("tenis"),
    THAILBOX("thaibox"),
    TRANPOLINA("trampolina"),
    TRX("trx"),
    VOLEJBAL("volejbal"),
    WORKOUT("workout"),
    ZUMBA("zumba");





    private String name;

    SportType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
