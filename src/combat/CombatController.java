package combat;

import character.Character;

public class CombatController {
    private final Combat combat;

    private final CombatDialog dialog;

    private Character winner;
    private Character looser;

    public CombatController(Combat combat) {
        this.combat = combat;
        dialog = new CombatDialog(this);
    }

    public void start() {
        boolean hasEnded = false;
        try {
            dialog.startBattle();
            while (!hasEnded){
                Thread.sleep(200);
                dialog.update(combat.fight());
                hasEnded = combat.defender().life() <= 0;
            }
            winner = combat.attacker();
            looser = combat.defender();
            dialog.endBattle();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Combat combat() {
        return combat;
    }

    public Character looser() {
        return looser;
    }

    public Character winner() {
        return winner;
    }
}
