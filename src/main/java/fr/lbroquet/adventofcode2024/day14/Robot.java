package fr.lbroquet.adventofcode2024.day14;

import static fr.lbroquet.adventofcode2024.day14.Main.SPACE_X;
import static fr.lbroquet.adventofcode2024.day14.Main.SPACE_Y;

class Robot {
    int x;
    int y;
    private final int vx;
    private final int vy;

    public Robot(int x, int y, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public void steps(int count) {
        for (int i = 0; i < count; i++) {
            x += vx;
            if(x < 0)
                x += SPACE_X;
            if(x >= SPACE_X)
                x -= SPACE_X;

            y += vy;
            if (y < 0)
                y += SPACE_Y;
            if (y >= SPACE_Y)
                y -= SPACE_Y;
        }
    }

    /**
     * <pre>
     *     +---+---+
     *     | 1 | 2 |
     *     +---+---+
     *     | 3 | 4 |
     *     +---+---+
     * </pre>
     * @return the quadrant number or 0 when between quadrants
     */
    public int quadrant() {
        if (y < SPACE_Y / 2) {
            if (x < SPACE_X / 2) {
                return 1;
            } else if (x >= (SPACE_X + 1) / 2) {
                return 2;
            }
        } else if (y >= (SPACE_Y + 1) / 2) {
            if (x < SPACE_X / 2) {
                return 3;
            } else if (x >= (SPACE_X + 1) / 2) {
                return 4;
            }
        }
        return 0;
    }
}
