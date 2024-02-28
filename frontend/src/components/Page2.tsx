import React, {useState} from 'react';
import { useNavigate } from 'react-router-dom';
import { useSelector } from 'react-redux';
import { RootState } from '../redux/store';
import axios from 'axios'

import { Button, Typography, Box, Card, CardContent } from '@mui/material'; // Import MUI components

const Page2 = () => {
  const { productName, productCount, price } = useSelector((state: RootState) => state.order);
  const navigate = useNavigate();
  const [error, setError] = useState('');

  const url = import.meta.env.VITE_API_URL;

  const goBack = () => {
    navigate('/');
  };

  const confirmOrder = async () => {
    try {
        const orderData = {
            productName,
            productCount,
            price
        }
      const response = await axios.post(url, orderData);

      if (response.status == 201) {
        console.log('Order confirmed successfully!');
        navigate('/page3');
        setError('');
      } else {
        // Handle error cases
        const errorData = response.data;
        setError(errorData.message);
      }
    } catch (error) {
      console.error('Network error:', error);
      setError('Произошла сетевая ошибка');
      setIsModalOpen(true);
    }
  };

    return (
      <Box sx={{ display: 'flex', justifyContent: 'center', alignItems: 'center', minHeight: '100vh' }}>
        <Card sx={{ maxWidth: 600, p: 3 }}>
          <CardContent>
            <Typography variant="h5" gutterBottom>
              Контроль введенных реквизитов и подтверждение
            </Typography>
            <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 2 }}>
              <Typography variant="body1">Наименование товара: {productName}</Typography>
              <Typography variant="body1">Кол-во товара: {productCount}</Typography>
              <Typography variant="body1">Оплаченная сумма: {price}</Typography>
            </Box>
            <Box sx={{ display: 'flex', justifyContent: 'space-between', mt: 3 }}>
              <Button variant="contained" onClick={goBack} sx={{ width: '48%' }}>
                Вернуться для редактирования
              </Button>
              <Button variant="contained" onClick={confirmOrder} sx={{ width: '48%' }}>
                Подтвердить заказ
              </Button>
            </Box>
            {error && <Typography variant="body1" color="error" sx={{ mt: 3 }}>{error}</Typography>}
          </CardContent>
        </Card>
      </Box>
    );
  };


export default Page2;
