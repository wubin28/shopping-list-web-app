<script setup lang="ts">
import ShoppingItemForm from '@/components/ShoppingItemForm.vue'
import { ElMessage } from 'element-plus'
import { onMounted, ref } from 'vue'
import axios from 'axios'

onMounted(async () => {
  await loadShoppingItems()
})

const shoppingItems = ref([])

async function loadShoppingItems() {
  try {
    const response = await axios.get('http://%%API_URL%%/api/v1/shopping-items')
    shoppingItems.value = response.data
    console.log('ShoppingItems', shoppingItems.value)
  } catch (error) {
    console.log('An error occurred:', error)
  }
}

interface ShoppingItem {
  id?: number
  item: string
  purchased: boolean
}

async function createShoppingItem(shoppingItem: ShoppingItem) {
  console.log('ShoppingItem', shoppingItem)
  await axios.post('http://%%API_URL%%/api/v1/shopping-items', {
    item: shoppingItem.item,
    purchased: shoppingItem.purchased
  })
  ElMessage({
    message: 'Shopping item created',
    type: 'success'
  })
  await loadShoppingItems()
}

async function updateShoppingItem(shoppingItem: ShoppingItem) {
  console.log('ShoppingItem', shoppingItem)
  await axios.put(`http://%%API_URL%%/api/v1/shopping-items/${shoppingItem.id}`, {
    id: shoppingItem.id,
    item: shoppingItem.item,
    purchased: shoppingItem.purchased
  })
  ElMessage({
    message: 'Shopping Item updated',
    type: 'success'
  })
  await loadShoppingItems()
}

function cancelDelete() {
  ElMessage({
    message: 'Delete canceled',
    type: 'info'
  })
}

async function deleteShoppingItemById(shoppingItem: ShoppingItem) {
  await axios.delete(`http://%%API_URL%%/api/v1/shopping-items/${shoppingItem.id}`)
  ElMessage({
    message: 'Shopping Item deleted',
    type: 'success'
  })
  await loadShoppingItems()
}
</script>

<template>
  <el-row>
    <el-col>
      <h1>ShoppingList</h1>
      <shopping-item-form @send-message="createShoppingItem"></shopping-item-form>
      <el-table :data="shoppingItems">
        <el-table-column prop="item" label="Item"></el-table-column>
        <el-table-column fixed="right" label="Operations">
          <template #default="scope">
            <el-space wrap>
              <el-switch
                v-model="scope.row.purchased"
                @change="updateShoppingItem(scope.row)"
              ></el-switch>
              <el-popconfirm
                cancel-button-text="No"
                confirm-button-text="Yes"
                icon="el-icon-info"
                icon-color="red"
                title="Are you sure to delete this shopping item?"
                @cancel="cancelDelete"
                @confirm="deleteShoppingItemById(scope.row)"
              >
                <template #reference>
                  <el-button size="small" type="danger">Delete</el-button>
                </template>
              </el-popconfirm>
            </el-space>
          </template>
        </el-table-column>
      </el-table>
    </el-col>
  </el-row>
</template>

<style scoped></style>
