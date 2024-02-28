import React from 'react';
import { useSelector } from 'react-redux';
import { RootState } from '../redux/store';
import { Typography, Box } from '@mui/material'; // Import MUI components

const Page3 = () => {
  const { productName, productCount, price } = useSelector((state: RootState) => state.order);

  return (
    <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', padding: 3 }}>
      <Typography variant="h5" gutterBottom>
        Просмотр деталей зарегистрированного заказа
      </Typography>
      <Box sx={{ display: 'flex', flexDirection: 'column', gap: 1 }}>
        <Typography variant="body1">
          Наименование товара: {productName}
        </Typography>
        <Typography variant="body1">
          Кол-во товара: {productCount}
        </Typography>
        <Typography variant="body1">
          Оплаченная сумма: {price}
        </Typography>
      </Box>
    </Box>
  );
};

export default Page3;
