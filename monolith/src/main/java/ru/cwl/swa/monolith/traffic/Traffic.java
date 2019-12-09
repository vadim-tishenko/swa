package ru.cwl.swa.monolith.traffic;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Traffic {
    final int objId;
    final long time;
    final float lat;
    final float lon;
}
