package com.Httymd.block.trees;

import java.util.Random;

import com.Httymd.lists.BlockList;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeature;

public class PineTree extends Tree {
	
	@Override
	protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
		return new TreeFeature(NoFeatureConfig::deserialize, true, 4, BlockList.pine_log.getDefaultState(), BlockList.pine_leaves.getDefaultState(), false).setSapling((net.minecraft.block.SaplingBlock)BlockList.pine_sapling);
	}
}
