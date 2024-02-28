import { createSlice, PayloadAction } from '@reduxjs/toolkit';

interface OrderState {
  productName: string;
  productCount: number;

  price: number;
}

const initialState: OrderState = {
  productName: '',
  productCount: 0,
  price: 0,
};

const orderSlice = createSlice({
  name: 'order',
  initialState,
  reducers: {
    setProductName: (state, action: PayloadAction<string>) => {
      state.productName = action.payload;
    },
    setProductCount: (state, action: PayloadAction<number>) => {
      state.productCount = action.payload;
    },

    setPrice: (state, action: PayloadAction<number>) => {
      state.price = action.payload;
    },
    setOrderData: (state, action: PayloadAction<OrderState>) => {
      const { productName, productCount, price } = action.payload;
      state.productName = productName;
      state.productCount = productCount;
      state.price = price;
    },
    clearOrder: (state) => {
      state.productName = '';
      state.productCount = 0;
      state.price = 0;
    },
  },
});

export const { setProductName, setProductCount, setPrice, setOrderData, clearOrder } = orderSlice.actions;

export default orderSlice.reducer;
