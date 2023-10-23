<script setup lang="ts">
import { ref } from 'vue'
import { ElForm, ElFormItem, ElInput, ElButton, ElMessage } from 'element-plus'

const formInput = ref({ item: '', purchased: false })

const emit = defineEmits(['send-message'])

const onSubmit = () => {
  if (formInput.value.item.length > 3) {
    emit('send-message', formInput.value)
  } else {
    ElMessage({
      message: 'Item must be longer than 3 characters',
      type: 'error'
    })
  }
  formInput.value.item = ''
}
</script>

<template>
  <el-form @submit.prevent :inline="true" :model="formInput" class="shopping-item-form-input">
    <el-form-item label="Item" prop="item">
      <el-input v-model="formInput.item" placeholder="Enter Item"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit()">Add</el-button>
    </el-form-item>
  </el-form>
</template>

<style scoped></style>
