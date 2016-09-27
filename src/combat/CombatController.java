package combat;

import character.Character;

class CombatController {
    private final Combat combat;

    private final CombatDialog dialog;

    private Character winner;
    private Character looser;

    CombatController(Combat combat) {
        this.combat = combat;
        dialog = new CombatDialog(this);
    }

    void start() {
        boolean hasEnded = false;
        try {
            dialog.startBattle();
            while (!hasEnded){
                Thread.sleep(200);
                combat.fight();
                dialog.update();
                hasEnded = combat.defender().life() <= 0;
            }
            winner = combat.attacker();
            looser = combat.defender();
            dialog.endBattle();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
