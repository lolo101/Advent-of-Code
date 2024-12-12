package fr.lbroquet.adventofcode2024.day9;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.addExact;
import static java.lang.Math.multiplyExact;

public class WholeFileChecksum {
    private final List<File> files = new ArrayList<>();
    private final List<Gap> gaps = new ArrayList<>();


    public WholeFileChecksum(String diskMap) {
        long block = 0;
        for (int position = 0; position < diskMap.length(); position++) {
            int positionLength = Integer.parseInt(String.valueOf(diskMap.charAt(position)));
            if (position % 2 == 0) {
                files.add(new File(block, positionLength));
            } else {
                gaps.add(new Gap(block, positionLength));
            }
            block += positionLength;
        }
    }

    public long defragmentedValue() {
        long checksum = 0;
        for (int fileId = files.size() - 1; fileId >= 0; --fileId) {
            long increment = availableGap(fileId);
            checksum = addExact(checksum, increment);
        }
        return checksum;
    }

    private long availableGap(int fileId) {
        File file = files.get(fileId);
        for (int gapId = 0; gapId < fileId; gapId++) {
            Gap gap = gaps.get(gapId);
            if (file.fitIn(gap)) {
                return gapFilledWithWholeFileChecksum(gap, fileId);
            }
        }
        return wholeFileChecksum(fileId);
    }

    private Long gapFilledWithWholeFileChecksum(Gap gap, int fileId) {
        int movedBlocks = files.get(fileId).length();
        return multiplyExact(fileId, gap.fill(movedBlocks));
    }

    private Long wholeFileChecksum(int fileId) {
        File file = files.get(fileId);
        return multiplyExact(fileId, file.ownRawChecksum());
    }
}
