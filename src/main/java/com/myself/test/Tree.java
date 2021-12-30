package com.myself.test;

import com.myself.utils.CopySourceName;
import lombok.Data;

@Data
public class Tree {
    @CopySourceName("name")
    private String treeName;
    @CopySourceName("age")
    private int treeAge;
    @CopySourceName("length")
    private Double treeLength;
}
