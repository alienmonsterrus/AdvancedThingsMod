package com.team_autists.advancedthings.blocks;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

// Специальный базовый блок для создания многоблочный структур.
public class TileMultiBlock extends TileEntity {

	private boolean hasMaster, isMaster;

	private int masterX, masterY, masterZ;

	public TileMultiBlock(TileEntityType tileEntityType) {
		super(tileEntityType);
	}

	public boolean isHasMaster() {
		return hasMaster;
	}
	public void setHasMaster(boolean hasMaster) {
		this.hasMaster = hasMaster;
	}

	public boolean isMaster() {
		return isMaster;
	}
	public void setMaster(boolean master) {
		isMaster = master;
	}

	public int getMasterX() {
		return masterX;
	}
	public void setMasterX(int masterX) {
		this.masterX = masterX;
	}

	public int getMasterY() {
		return masterY;
	}
	public void setMasterY(int masterY) {
		this.masterY = masterY;
	}

	public int getMasterZ() {
		return masterZ;
	}
	public void setMasterZ(int masterZ) {
		this.masterZ = masterZ;
	}

	public void setMasterCoords(int x, int y, int z) {
		masterX = x;
		masterY = y;
		masterZ = z;
	}

	@Override
	public NBTTagCompound write(NBTTagCompound data) {
		super.write(data);

		data.setInt("masterX", masterX);
		data.setInt("masterY", masterY);
		data.setInt("masterZ", masterZ);
		data.setBoolean("hasMaster", hasMaster);
		data.setBoolean("isMaster", isMaster);

		// Все остальные значения должны
		// сохраняться только в мастер.
		if (hasMaster && isMaster) {

		}

		return data;
	}

	@Override
	public void read(NBTTagCompound data) {
		super.read(data);

		masterX = data.getInt("masterX");
		masterY = data.getInt("masterY");
		masterZ = data.getInt("masterZ");
		hasMaster = data.getBoolean("hasMaster");
		isMaster = data.getBoolean("isMaster");

		// Любые другие значения должны быть
		// прочитаны только мастером.
		if (hasMaster && isMaster) {

		}
	}

	// Метод проверящий является ли структура многоблочной.
	public boolean checkMultiBlockForm() {

		BlockPos pos = getPos();
		int xCoord = pos.getX();
		int yCoord = pos.getY();
		int zCoord = pos.getZ();

		int i = 0;

		// Сканирование области 3x3x3, начиная с нижнего левого угла
		for (int x = xCoord - 1; x < xCoord + 2; x++)
			for (int y = yCoord; y < yCoord + 3; y++)
				for (int z = zCoord - 1; z < zCoord + 2; z++) {
					TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
					// Проверка на то, что tile не является нулевым,
					// и является экземпляром одного и того же Tile
					// и еще не является частью многоблочной структуры.
					if (tile != null && (tile instanceof TileMultiBlock)) {
						if (this.isMaster()) {
							if (((TileMultiBlock)tile).isHasMaster()) i++;
						}
						else if (!((TileMultiBlock)tile).isHasMaster()) i++;
					}
				}
		// Проверка на наличие 26 блоков ((3 * 3 * 3) - 1) и проверяем, что центральный блок пуст.
		return i > 25 && world.isAirBlock(new BlockPos(xCoord, yCoord + 1, zCoord));
	}

	public void setupStructure() {

		BlockPos pos = getPos();
		int xCoord = pos.getX();
		int yCoord = pos.getY();
		int zCoord = pos.getZ();

		for (int x = xCoord - 1; x < xCoord + 2; x++) {
			for (int y = yCoord; y < yCoord + 3; y++) {
				for (int z = zCoord - 1; z < zCoord + 2; z++) {

					TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));

					// Проверка: является ли блок, нижним центральным блоком
					boolean master = (x == xCoord && y == yCoord && z == zCoord);
					if (tile != null && (tile instanceof TileMultiBlock)) {
						((TileMultiBlock) tile).setMasterCoords(xCoord, yCoord, zCoord);
						((TileMultiBlock) tile).setHasMaster(true);
						((TileMultiBlock) tile).setMaster(master);
					}
				}
			}
		}
	}

	// Метод сброса, который должен запускаться,
	// когда master сломался.
	public void reset() {
		masterX = 0;
		masterY = 0;
		masterZ = 0;
		hasMaster = false;
		isMaster = false;
	}

	protected void onStructureInteract() {

	}

	public boolean checkForMaster() {
		TileEntity tile = world.getTileEntity(new BlockPos(masterX, masterY, masterZ));
		return (tile != null && (tile instanceof TileMultiBlock));
	}

	public void resetStructure() {

		BlockPos pos = getPos();
		int xCoord = pos.getX();
		int yCoord = pos.getY();
		int zCoord = pos.getZ();

		for (int x = xCoord - 1; x < xCoord + 2; x++)
			for (int y = yCoord; y < yCoord + 3; y++)
				for (int z = zCoord - 1; z < zCoord + 2; z++) {
					TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
					if (tile != null && (tile instanceof TileMultiBlock))
						((TileMultiBlock) tile).reset();
				}
	}


}
