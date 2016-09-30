package equipment.armours;

import categories.hero.Assassin;
import categories.hero.Paladin;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

public class Armours_ {

    @Test
    public void should_have_basics_stats_and_class_requirement_with_one_class() throws Exception {
        Armour armour = new ArmourBuilder().levelRequirement(5).protection(15.2).classRequirement(new Paladin()).build();
        assertThat(armour.requirement(), is(not(nullValue())));
        assertThat(armour.protection(), is(not(nullValue())));
        assertThat(armour.allowTo(Paladin.class), is(true));
    }
    @Test
    public void should_have_basics_stats_and_class_requirement_with_two_classes() throws Exception {
        Armour armour = new ArmourBuilder().levelRequirement(5).protection(15.2).classRequirement(new Paladin(), new Assassin()).build();
        assertThat(armour.requirement(), is(not(nullValue())));
        assertThat(armour.protection(), is(not(nullValue())));
        assertThat(armour.allowTo(Paladin.class), is(true));
        assertThat(armour.allowTo(Assassin.class), is(true));
    }
}
