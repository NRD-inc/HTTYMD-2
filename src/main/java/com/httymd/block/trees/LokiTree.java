package com.httymd.block.trees;

import com.httymd.lists.BlockList;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeature;

import java.util.Random;

public class LokiTree extends Tree {

    @Override
    protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
        return new TreeFeature(NoFeatureConfig::deserialize, true, 4, BlockList.loki_log.getDefaultState(), BlockList.loki_leaves.getDefaultState(), false).setSapling((net.minecraft.block.SaplingBlock) BlockList.loki_sapling);
    }

}
