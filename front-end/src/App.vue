<script setup lang="ts">
import ShoppingList from '@/components/ShoppingList.vue'
import { ElContainer, ElMain } from 'element-plus'
</script>

<template>
  <el-container>
    <el-main>
      <shopping-list></shopping-list>
    </el-main>
  </el-container>
</template>

<style scoped>
body {
  margin: 0;
}

.el-container {
  background-color: #e9eef3;
  color: var(--el-text-color-primary);
  text-align: center;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
}
</style>
