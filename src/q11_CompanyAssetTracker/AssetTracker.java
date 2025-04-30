package q11_CompanyAssetTracker;

import java.util.*;

// Asset class
class Asset {
    String assetId;
    String name;

    public Asset(String assetId, String name) {
        this.assetId = assetId;
        this.name = name;
    }

    // Uniqueness based on assetId
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Asset)) return false;
        Asset asset = (Asset) o;
        return Objects.equals(assetId, asset.assetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assetId);
    }

    @Override
    public String toString() {
        return assetId + " - " + name;
    }
}

public class AssetTracker {
    public static void main(String[] args) {
        // Map: department -> set of unique assets
        Map<String, Set<Asset>> departmentAssets = new HashMap<>();

        // Global set to track all asset IDs
        Set<String> globalAssetIds = new HashSet<>();

        // Add assets
        addAsset(departmentAssets, globalAssetIds, "IT", new Asset("A001", "Laptop"));
        addAsset(departmentAssets, globalAssetIds, "HR", new Asset("A002", "Projector"));
        addAsset(departmentAssets, globalAssetIds, "IT", new Asset("A003", "Server"));
        addAsset(departmentAssets, globalAssetIds, "Finance", new Asset("A001", "Laptop")); // Duplicate globally

        // Print department assets
        printDepartmentAssets(departmentAssets);
    }

    // Add asset to a department if asset ID is unique globally
    public static void addAsset(Map<String, Set<Asset>> deptMap, Set<String> globalIds, String department, Asset asset) {
        if (globalIds.contains(asset.assetId)) {
            System.out.println("Duplicate asset ID detected: " + asset.assetId + " - Skipping.");
            return;
        }
        deptMap.computeIfAbsent(department, k -> new HashSet<>()).add(asset);
        globalIds.add(asset.assetId);
    }

    // Print assets per department
    public static void printDepartmentAssets(Map<String, Set<Asset>> deptMap) {
        for (Map.Entry<String, Set<Asset>> entry : deptMap.entrySet()) {
            System.out.println("Department: " + entry.getKey());
            for (Asset asset : entry.getValue()) {
                System.out.println("  " + asset);
            }
        }
    }
}

