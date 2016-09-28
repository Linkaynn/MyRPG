package combat;

import character.Character;
import util.Util;

class CombatController {
    private final Combat combat;

    private final CombatDialog dialog;

    private boolean fastCombat = false;

    private Character winner;
    private Character looser;

    CombatController(Combat combat) {
        this.combat = combat;
        dialog = new CombatDialog(this);
    }

    public CombatController(Combat combat, boolean fastCombat) {
        this(combat);
        this.fastCombat = fastCombat;
    }

    void start() {
        boolean hasEnded = false;
        dialog.startBattle();
        while (!hasEnded){
            combat.fight();
            if (!fastCombat) {
                dialog.update();
                Util.sleep(200);
            }
            hasEnded = combat.defender().life() <= 0;
        }
        winner = combat.attacker();
        looser = combat.defender();
        dialog.endBattle();
    }

    Combat combat() {
        return combat;
    }

    Character looser() {
        return looser;
    }

    Character winner() {
        return winner;
    }
}
