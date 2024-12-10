package fr.lbroquet.adventofcode2024.day9;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class Checksum {
    private final List<Integer> files = new ArrayList<>();
    private final List<Integer> gaps = new ArrayList<>();
    private final Block block = new Block();


    public Checksum(String diskMap) {
        for (int position = 0; position < diskMap.length(); position++) {
            int positionLength = Integer.parseInt(String.valueOf(diskMap.charAt(position)));
            if (position % 2 == 0) {
                files.add(positionLength);
            } else {
                gaps.add(positionLength);
            }
        }
    }

    public long defragmentedValue() {
        long checksum = 0;
        for (int position = 0, id = 0; id < files.size(); id = ++position / 2) {
            if (position % 2 == 0) {
                checksum = addExact(checksum, moveFileInPlace(id));
            } else if (id < gaps.size()) {
                checksum = addExact(checksum, fillGap(id));
            }
        }
        return checksum;
    }

    private long moveFileInPlace(int fileId) {
        long fileSize = files.get(fileId);
        long positionChecksum = multiplyExact(fileId, block.rawChecksumAndIncrement(fileSize));
        files.set(fileId, 0);
        return positionChecksum;
    }

    private long fillGap(int id) {
        long positionChecksum = 0;
        int gapSize = gaps.get(id);
        for (
                int lastFileId = files.size() - 1;
                gapSize > 0 && lastFileId >= 0;
                lastFileId = files.size() - 1) {
            int lastFileSize = files.get(lastFileId);
            int movedBlocks = min(gapSize, lastFileSize);
            positionChecksum = addExact(positionChecksum, multiplyExact(lastFileId, block.rawChecksumAndIncrement(movedBlocks)));
            gapSize -= movedBlocks;
            lastFileSize -= movedBlocks;
            if (lastFileSize == 0) {
                files.removeLast();
            } else {
                files.set(lastFileId, lastFileSize);
            }
        }
        return positionChecksum;
    }
}
