package combat;

import java.util.Date;

public class CombatDialog {
    private final CombatController controller;

    public CombatDialog(CombatController controller) {
        this.controller = controller;
    }

    public void startBattle() {
        System.out.println(String.format("%s\n%s vs %s", new Date(), controller.combat().hero().name(), controller.combat().monster().name()));
    }

    public void update(double damage) {
        Combat combat = controller.combat();
        try {
            if (!combat.dodged()) {
                System.out.println(String.format("%s\t\t\t\t%s\n%s/%s\t\t\t\t%s/%s\n\n\n\n", combat.attacker(), combat.defender(), format(combat.attacker().life()), format(combat.attacker().maxLife()), format(combat.defender().life()), format(combat.defender().maxLife())));
            }else {
                System.out.println(String.format("\n%s dodged %s attack!!", combat.defender(), combat.attacker()));
                Thread.sleep(300);
            }
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void endBattle() {
        System.out.println(String.format("Battle ended!\nThe winner is %s\nThe looser is %s", controller.winner(), controller.looser()));
    }

    private String format(double value){
        return String.format("%.2f", value);
    }
}
