package com.bmuschko.junit5.samples.extension.tmp;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;

@Tag("uses-temporary-dir")
@ExtendWith(TemporaryFolderExtension.class)
public interface TemporaryFolderPrerequisite {
}
