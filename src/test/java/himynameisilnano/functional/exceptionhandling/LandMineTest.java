package himynameisilnano.functional.exceptionhandling;

import org.junit.jupiter.api.Test;

import java.util.List;

class LandMineTest {

    @Test
    void try_to_unload_several_land_mines() {
        List<LandMine<?>> landMines = List.of(new LandMine<>(() -> 1 + 1),
                new LandMine<>(() -> "safe"),
                new LandMine<>(() -> 0 / 5),
                new LandMine<>(() -> 1 / 0));

        List<?> list = landMines.stream()
                .map(LandMine::unload)
                .map(Try::data)
                .toList();

        System.out.println(list);
    }
}